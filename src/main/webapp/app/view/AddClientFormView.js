/**
 * Created by ���� on 02.09.2015.
 */

Ext.define('Brooklyn.view.AddClientFormView', {
    extend: 'Ext.window.Window',
    alias: 'widget.addClientFormView',
    title: 'Добавление клиента',
    autoShow: true,
    height: 700,
    width: 900,
    layout: 'fit',
    modal: true,
    config : {
        action : '',
        recordIndex : 0
    },
    items: [
        {
            bodyPadding: 10,
            xtype: 'form',
            items: [
                {
                    xtype: 'addClientFieldsView'
                },
                {
                    xtype: 'panel',
                    html: '<div style="font: normal 18px cursive"><center><font size = "4">Дополнительные контакты:</font></center></div>',
                    height: 40
                },
                {
                    xtype: 'parentsGridView'
                },
                {
                    xtype: 'panel',
                    height: 10
                },
                {
                    xtype: 'panel',
                    html: '<div style="font: normal 18px cursive"><center><font size = "4">История разговора:</font></center></div>',
                    height: 40
                },
                {
                    xtype: 'storyGridView'
                }
            ]
        }
    ],

    buttons: [
        {
            text: 'Сохранить',
            action: 'save'
        },
        {
            text: 'Отмена',
            action: 'close'

        }
    ]
});