/**
 * Created by ���� on 02.09.2015.
 */

Ext.define('Email.view.AddAddressBookFormView', {
    extend: 'Ext.window.Window',
    alias: 'widget.addAddressBookFormView',
    title: 'Добавление адресной книги',
    autoShow: true,
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
                    xtype:'textfield',
                    fieldLabel: 'Название',
                    name: 'name'
                },
                {
                    xtype:'textarea',
                    fieldLabel: 'Адреса',
                    name: 'emails'
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