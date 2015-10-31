/**
 * Created by ���� on 02.09.2015.
 */

Ext.define('Brooklyn.view.SearchClientView', {
    extend: 'Ext.form.Panel',
    alias: 'widget.searchClientView',
    bodyPadding: 10,

    items: [
        {
            xtype: 'textfield',
            name: 'searchName',
            fieldLabel: 'Имя:',
            maxLength: 200,
            width: 260
        },
        {
            xtype: 'textfield',
            name: 'searchEmail',
            fieldLabel: 'E-mail:',
            maxLength: 200,
            width: 260
        },
        {
            xtype: 'textfield',
            name: 'searchPhone',
            fieldLabel: 'Телефон:',
            maxLength: 200,
            width: 260
        }
    ]
});