/**
 * Created by ���� on 02.09.2015.
 */

Ext.define('Sms.view.AddSmsPatternFormView', {
    extend: 'Ext.window.Window',
    alias: 'widget.addSmsPatternFormView',
    title: 'Добавление шаблона сообщения',
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
                    xtype: 'textarea',
                    fieldLabel: 'Текст SMS',
                    name: 'textSms'
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