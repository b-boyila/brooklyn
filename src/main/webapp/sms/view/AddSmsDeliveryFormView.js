/**
 * Created by ���� on 02.09.2015.
 */

Ext.define('Sms.view.AddSmsDeliveryFormView', {
    extend: 'Ext.window.Window',
    alias: 'widget.addSmsDeliveryFormView',
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
                    fieldLabel: 'SMS от',
                    name: 'nameSender'
                },
                {
                    xtype:'combobox',
                    fieldLabel: 'Шаблон сообщения',
                    name: 'smsPattern'
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