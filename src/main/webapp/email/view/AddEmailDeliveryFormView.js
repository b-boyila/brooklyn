/**
 * Created by ���� on 02.09.2015.
 */

Ext.define('Email.view.AddEmailDeliveryFormView', {
    extend: 'Ext.window.Window',
    alias: 'widget.addEmailDeliveryFormView',
    title: 'Добавление рассылки',
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
                    fieldLabel: 'Имя отправителя',
                    name: 'nameSender'
                },
                {
                    xtype:'textfield',
                    fieldLabel: 'Адрес отправителя',
                    name: 'addressSender'
                },
                {
                    xtype:'textfield',
                    fieldLabel: 'Тема сообщения',
                    name: 'subject'
                },
                {
                    xtype:'combobox',
                    fieldLabel: 'Шаблон сообщения',
                    name: 'emailPattern'
                },
                {
                    xtype:'combobox',
                    fieldLabel: 'Адресная книга',
                    name: 'addressBook'
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