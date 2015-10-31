/**
 * Created by Илья on 16.09.2015.
 */

Ext.define('Brooklyn.view.SendClientView', {
    extend: 'Ext.form.Panel',
    alias: 'widget.sendClientView',
    bodyPadding: 10,
    items: [
        {
            xtype: 'checkboxgroup',
            fieldLabel: 'Клиенты',
            columns: 1,
            style: {
                padding: '5px 10px 5px 10px'
            },
            items: [{
                xtype: 'checkbox',
                boxLabel: '0,1',
                name: 'с01',
                inputValue: '0.1'
            }, {
                xtype: 'checkbox',
                boxLabel: '0,5',
                name: 'c05',
                inputValue: '0.5'
            }, {
                xtype: 'checkbox',
                boxLabel: '0,9',
                name: 'c09',
                inputValue: '0.9'
            }, {
                xtype: 'checkbox',
                boxLabel: '1',
                name: 'c1',
                inputValue: '1'
            }]
        },
        {
            xtype: 'button',
            name: 'sendEmail',
            text: 'Отправить письма отмеченным',
            region: 'centre',
            height: 70,
            width: 260
        },
        {
            xtype: 'panel',
            region: 'north',
            height: 30
        },
        {
            xtype: 'button',
            name: 'sendSMS',
            text: 'Отправить SMS отмеченным',
            region: 'centre',
            height: 70,
            width: 260
        }
    ]
});