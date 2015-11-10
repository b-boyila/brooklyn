/**
 * Created by ���� on 02.09.2015.
 */

Ext.define('Email.view.EmailDeliveryGridView', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.emailDeliveryGridView',
    height: 600,
    frame: true,
    iconCls: 'icon-user',
    columns: [
        {
            flex: 1,
            text: 'Имя отправителя',
            sortable: true,
            dataIndex: 'nameSender'
        },
        {
            flex: 1,
            text: 'Адрес отправителя',
            sortable: true,
            dataIndex: 'addressSender'
        },
        {
            flex: 1,
            text: 'Тема сообщения',
            sortable: true,
            dataIndex: 'subject'
        },
        {
            flex: 1,
            text: 'Шаблон сообщения',
            sortable: true,
            dataIndex: 'emailPattern'
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