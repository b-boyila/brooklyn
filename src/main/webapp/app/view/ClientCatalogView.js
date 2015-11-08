/**
 * Created by ???? on 02.09.2015.
 */

Ext.define('Brooklyn.view.ClientCatalogView', {
    extend: 'Ext.panel.Panel',
    width: 500,
    height: 360,
    padding: 10,
    alias: 'widget.clientCatalogView',
    layout: "border",
    items: [
        {
            title: 'Brooklyn - Клиентская база',
            xtype: 'clientGridView',
            region: 'center'
        },
        /*{
            xtype: 'panel',
            html: '<a href="http://brooklyn74.ru" target="_blank"><img style="position: absolute; width: 80px; height: 80px; margin: 20px;" src="/resources/image/logo.png"/></a><div style="font: normal 18px cursive; text-align: center;"><font size = "8">Brooklyn<br></font><font size = "6">Клиентская база</font></div>',
            region: 'north',
            height: 120
        },*/
        {
            xtype: 'toolClientView',
            title: 'Инструменты',
            region: 'west',
            width: 300,
            collapsible: true,
            collapsed: true
        }
    ],
    renderTo: Ext.getBody()
});