/**
 * Created by Илья on 15.09.2015.
 */

Ext.define('Sms.controller.SmsController', {
    extend: 'Ext.app.Controller',

    init: function () {
        this.control({
            'smsDeliveryGridView  button[action=add]': {
                click: this.onAddSmsDelivery
            },
            'addSmsDeliveryFormView  button[action=close]': {
                click: this.onCloseSmsDeliveryForm
            },
            'addressBookGridView  button[action=add]': {
                click: this.onAddAddressBook
            },
            'addAddressBookFormView  button[action=close]': {
                click: this.onCloseAddressBookForm
            },
            'smsPatternGridView  button[action=add]': {
                click: this.onAddSmsPattern
            },
            'addSmsPatternFormView  button[action=close]': {
                click: this.onCloseAddSmsPatternForm
            }

        });
    },

    onAddSmsDelivery: function () {
        var view = Ext.widget('addSmsDeliveryFormView');
    },

    onCloseSmsDeliveryForm: function (button){
        button.up('window').close();
    },

    onAddAddressBook: function () {
        var view = Ext.widget('addAddressBookFormView');
    },

    onCloseAddressBookForm: function (button){
        button.up('window').close();
    },

    onAddSmsPattern: function () {
        var view = Ext.widget('addSmsPatternFormView');
    },

    onCloseAddSmsPatternForm: function (button){
        button.up('window').close();
    }


});
