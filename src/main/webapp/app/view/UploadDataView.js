/**
 * Created by Илья on 16.09.2015.
 */

Ext.define('Brooklyn.view.UploadDataView', {
    extend: 'Ext.form.Panel',
    alias: 'widget.uploadDataView',
    bodyPadding: 10,
    items: [
        {
            xtype: 'checkboxgroup',
            fieldLabel: 'Клиенты',
            columns: 2,
            items: [{
                xtype: 'checkbox',
                boxLabel: '0,1',
                name: 'c01',
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
            name: 'uploadDate',
            text: 'Выгрузить'
        }
    ]
});