/**
 * Created by Илья on 17.09.2015.
 */

Ext.define('Brooklyn.view.ToolClientView', {
    extend: 'Ext.form.Panel',
    alias: 'widget.toolClientView',
    bodyPadding: 10,
    layout: 'accordion',
    items: [{
           hidden: true
        },
        {
            xtype: 'searchClientView',
            title: 'Поиск',
            region: 'west',
            width: 280,
            collapsed: true
        },
        {
            xtype: 'sendClientView',
            title: 'Отправка писем и SMS',
            region: 'west',
            width: 280,
            collapsed: true
        }
    ]
});