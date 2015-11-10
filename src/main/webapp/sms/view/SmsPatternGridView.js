/**
 * Created by ���� on 02.09.2015.
 */

Ext.define('Sms.view.SmsPatternGridView', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.smsPatternGridView',
    height: 600,
    frame: true,
    iconCls: 'icon-user',
    columns: [
        {
            flex: 1,
            text: 'Название',
            sortable: true,
            dataIndex: 'smsPattern'
        }
    ],
    dockedItems: [
        {
            xtype: 'toolbar',
            items: [
                {
                    text: 'Добавить',
                    action: 'add',
                    iconCls: 'icon-add'
                },
                '-',
                {
                    action: 'delete',
                    text: 'Удалить',
                    iconCls: 'icon-delete',
                    disabled: false
                }
            ]
        }
    ]
});