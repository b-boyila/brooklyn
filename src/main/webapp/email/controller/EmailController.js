/**
 * Created by Илья on 15.09.2015.
 */

Ext.define('Email.controller.EmailController', {
    extend: 'Ext.app.Controller',

    init: function () {
        this.control({
            'emailDeliveryGridView  button[action=add]': {
                click: this.onAddEmailDelivery
            },
            'addEmailDeliveryFormView  button[action=close]': {
                click: this.onCloseEmailDeliveryForm
            },
            'addressBookGridView  button[action=add]': {
                click: this.onAddAddressBook
            },
            'addAddressBookFormView  button[action=close]': {
                click: this.onCloseAddressBookForm
            },
            'emailPatternGridView  button[action=add]': {
                click: this.onAddEmailPattern
            },
            'addEmailPatternFormView  button[action=close]': {
                click: this.onCloseAddEmailPatternForm
            }

        });
    },

    onAddEmailDelivery: function () {
        var view = Ext.widget('addEmailDeliveryFormView');
    },

    onCloseEmailDeliveryForm: function (button){
        button.up('window').close();
    },

    onAddAddressBook: function () {
        var view = Ext.widget('addAddressBookFormView');
    },

    onCloseAddressBookForm: function (button){
        button.up('window').close();
    },

    onAddEmailPattern: function () {
        var view = Ext.widget('addEmailPatternFormView');
        tinymce.init({
            selector: "#emailPattern",
            height: 500,
            width: 600
        });
    },

    onCloseAddEmailPatternForm: function (button){
        button.up('window').close();
    }


});
