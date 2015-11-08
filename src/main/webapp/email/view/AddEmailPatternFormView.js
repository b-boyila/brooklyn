/**
 * Created by ���� on 02.09.2015.
 */

Ext.define('Email.view.AddEmailPatternFormView', {
    extend: 'Ext.window.Window',
    alias: 'widget.addEmailPatternFormView',
    title: 'Добавление шаблона сообщения',
    autoShow: true,
    height: 720,
    width: 634,
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
                    xtype: 'panel',
                    height: 620,
                    width: 610,
                    html: '<form method="post"><textarea id="pattern"></textarea></form>'
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