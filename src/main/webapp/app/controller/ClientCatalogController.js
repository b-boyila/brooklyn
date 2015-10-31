/**
 * Created by Илья on 15.09.2015.
 */

Ext.define('Brooklyn.controller.ClientCatalogController', {
    extend: 'Ext.app.Controller',

    refs: [

        {selector: 'clientGridView button[action="add"]',
            ref: 'addClientButton'},
        {selector: 'clientGridView button[action="delete"]',
            ref: 'deleteClientButton'},
        {selector: 'addClientFieldsView',
            ref: 'addClientFieldsView'},
        {selector: 'addClientFormView',
            ref: 'addClientFormView'},
        {selector: 'clientGridView',
            ref: 'clientGridView'},
        {selector: 'parentsGridView',
            ref: 'parentsGridView'},
        {selector: 'storyGridView',
            ref: 'storyGridView'},
        {selector: 'parentsGridView button[action="add"]',
            ref: 'addParentsButton'},
        {selector: 'parentsGridView button[action="delete"]',
            ref: 'deleteParentsButton'},
        {selector: 'storyGridView button[action="add"]',
            ref: 'addStoryButton'},
        {selector: 'storyGridView button[action="delete"]',
            ref: 'deleteStoryButton'}
    ],

    init: function () {
        this.control({
            'clientGridView  button[action=add]': {
                click: this.onAddClient
            },
            'clientGridView  button[action=delete]': {
                click: this.onDeleteClient
            },
            'addClientFormView  button[action=save]': {
                click: this.onSaveClient
            },
            'addClientFormView  button[action=close]': {
                click: this.onCloseForm
            },
            'clientGridView': {
                itemdblclick: this.onEditClient
            },
            'parentsGridView  button[action=add]': {
                click: this.onAddParent
            },
            'parentsGridView  button[action=delete]': {
                click: this.onDeleteParent
            },
            'storyGridView  button[action=add]': {
                click: this.onAddStory
            },
            'storyGridView  button[action=delete]': {
                click: this.onDeleteStory
            }
        });
    },

    onCloseForm: function (button){
        var parentsStore = Ext.getStore('ParentsCatalogStore');
        var storyStore = Ext.getStore('StoryCatalogStore');
        parentsStore.removeAll();
        storyStore.removeAll();
        button.up('window').close();
    },

    onSaveClient: function () {
        var view = this.getAddClientFormView();
        var form = view.down('form');
        var values = form.getValues();
        var client = form.getRecord();
        var clientsStore = Ext.getStore('ClientCatalogStore');
        var parentsStore = Ext.getStore('ParentsCatalogStore');
        var storyStore = Ext.getStore('StoryCatalogStore');
        var parents = parentsStore.getRange();
        var story = storyStore.getRange();
        var action = view.getAction();

        if(action == 'edit') {
            client.parents().removeAll();
            client.story().removeAll();
        }

        client.set(values);
        client.parents().add(parents);
        client.story().add(story);
        client.set(client.getAssociatedData());

        for (var i = 0; i < parents.length; i++) {
            client.data.parents[i].id = null;
        }

        for (var j = 0; j < story.length; j++) {
            client.data.story[j].id = null;
        }

        client.save({
            callback : function(record, operation) {
                if (operation.wasSuccessful()) {
                    parentsStore.removeAll();
                    storyStore.removeAll();
                    clientsStore.add(record);
                    clientsStore.commitChanges();
                    clientsStore.reload();
                    view.close();
                } else {
                    Ext.MessageBox.show({
                        title:'Ошибка сохранения',
                        msg: 'Обратитесь в техническую поддержку. Тест ошибки: ' + operation.error.statusText,
                        buttonText: {ok: "Хорошо"},
                        icon: Ext.MessageBox.ERROR
                    })


                }
            }
        });

    },

    onAddClient: function () {
        var client = Ext.create('Brooklyn.model.ClientCatalogModel');
        client.set("id", null);
        var view = Ext.widget('addClientFormView');
        view.down('form').loadRecord(client);
        view.setAction('add');
    },

    onDeleteClient: function (button) {
        var grid = button.up('grid');
        var sm = grid.getSelectionModel();
        var rs = sm.getSelection();
        var client = rs[0].getData();
        Ext.MessageBox.show({
            title: 'Удалить сотрудника',
            msg: 'Вы уверенны?',
            buttonText: {yes: "Да",no: "Нет"},
            icon: Ext.MessageBox.QUESTION,
            fn: function (btn) {
                if (btn == 'yes') {
                    Ext.Ajax.request({
                        url: '/clients/delete',
                        method: 'POST',
                        jsonData: client,
                        success: function () {
                            grid.store.remove(rs[0]);
                            grid.store.commitChanges();
                        }
                    });
                }
            }
        });

    },

    onEditClient: function(grid, record, item, index) {
        var clientsStore = Ext.getStore('ClientCatalogStore');
        var parentsStore = Ext.getStore('ParentsCatalogStore');
        var storyStore = Ext.getStore('StoryCatalogStore');
        var client = clientsStore.getAt(clientsStore.indexOf(record));
        var view = Ext.widget('addClientFormView');
        parentsStore.add(client.parents().data.items);
        storyStore.add(client.story().data.items);
        view.down('form').loadRecord(client);
        view.setAction('edit');

    },

    onAddParent: function () {
        var parentsGrid = this.getParentsGridView();
        var parentsStore = parentsGrid.getStore();
        var parent = Ext.create('Brooklyn.model.ParentsCatalogModel');
        parentsStore.add(parent);
        parentsStore.commitChanges();
        parent.set("secondName", "Иванов");
        parent.set("firstName", "Иван");
        parent.set("lastName", "Иванович");
        parent.set("kin", "Отец");
        parent.set("phone", "89080434717");
        parent.set("email", "ivan@mail.ru");
        parentsGrid.editingPlugin.startEdit(parent, 0);
    },

    onDeleteParent: function (button) {
        var grid = button.up('grid');
        var sm = grid.getSelectionModel();
        var rs = sm.getSelection();
        Ext.MessageBox.show({
            title: 'Удалить контакт',
            msg: 'Вы уверенны?',
            buttonText: {yes: "Да",no: "Нет"},
            icon: Ext.MessageBox.QUESTION,
            fn: function (btn) {
                if (btn == 'yes') {
                    grid.store.remove(rs[0]);
                    grid.store.commitChanges();
                }
            }
        });
    },

    onAddStory: function () {
        var storyGrid = this.getStoryGridView();
        var storyStore = storyGrid.getStore();
        var story = Ext.create('Brooklyn.model.StoryCatalogModel');
        storyStore.add(story);
        storyStore.commitChanges();
        story.set("comment", "Телефон недоступен");
        storyGrid.editingPlugin.startEdit(story, 0);
    },

    onDeleteStory: function (button) {
        var grid = button.up('grid');
        var sm = grid.getSelectionModel();
        var rs = sm.getSelection();
        Ext.MessageBox.show({
            title: 'Удалить комментарий',
            msg: 'Вы уверенны?',
            buttonText: {yes: "Да",no: "Нет"},
            icon: Ext.MessageBox.QUESTION,
            fn: function (btn) {
                if (btn == 'yes') {
                    grid.store.remove(rs[0]);
                    grid.store.commitChanges();
                }
            }
        });
    }
});
