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
            name: 'name',
            fieldLabel: 'Имя:',
            maxLength: 200,
            width: 260,
            id: 'nameSearch'
        },
        {
            xtype: 'textfield',
            name: 'email',
            fieldLabel: 'E-mail:',
            maxLength: 200,
            width: 260,
            id: 'emailSearch'
        },
        {
            xtype: 'textfield',
            name: 'phone',
            fieldLabel: 'Телефон:',
            maxLength: 200,
            width: 260,
            id: 'phoneSearch'
        },
        {
            xtype: 'toolbar',
            items: [
                {
                    xtype: 'button',
                    action: 'search',
                    text: 'Поиск'
                },
                {
                    xtype: 'button',
                    action: 'clean',
                    text: 'Очистить'
                }
            ]
        }
    ]
});