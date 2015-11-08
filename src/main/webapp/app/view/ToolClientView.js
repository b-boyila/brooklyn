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
            xtype: 'uploadDataView',
            title: 'Выгрузить данные',
            region: 'west',
            width: 280,
            collapsed: true
        },
        {
            xtype: 'sendEmailView',
            title: 'E-mail рассылка',
            region: 'west',
            width: 280,
            hideCollapseTool: true,
            listeners : {
                beforeexpand : function(){
                    return false;
                }
            }
        },
        {
            xtype: 'sendSmsView',
            title: 'Sms рассылка',
            region: 'west',
            width: 280,
            hideCollapseTool: true,
            listeners : {
                beforeexpand : function(){
                    return false;
                }
            }
        }
    ]
});