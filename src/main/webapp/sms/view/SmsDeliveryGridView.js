/**
 * Created by ���� on 02.09.2015.
 */

Ext.define('Sms.view.SmsDeliveryGridView', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.smsDeliveryGridView',
    height: 600,
    frame: true,
    iconCls: 'icon-user',
    columns: [
        {
            flex: 1,
            text: 'SMS от',
            sortable: true,
            dataIndex: 'nameSender'
        },
        {
            flex: 1,
            text: 'Шаблон сообщения',
            sortable: true,
            dataIndex: 'smsPattern'
        },
        {
            flex: 1,
            text: 'Адресная книга',
            sortable: true,
            dataIndex: 'addressBook'
        }

    ],
    dockedItems: [
        {
            xtype: 'toolbar',
            items: [
                {
                    action: 'run',
                    text: 'Запустить',
                    iconCls: 'icon-run'
                }
                ,
                '-',
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