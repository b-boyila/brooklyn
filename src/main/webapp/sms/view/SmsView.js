/**
 * Created by ???? on 02.09.2015.
 */
Ext.define('Sms.view.SmsView', {
    extend: 'Ext.form.Panel',
    alias: 'widget.smsView',
    layout: 'accordion',
    items: [
        {
            xtype: 'smsDeliveryGridView',
            title: 'Создать рассылку',
            region: 'west',
            collapsed: true

        },
        {
            xtype: 'addressBookGridView',
            title: 'Адресные книги',
            region: 'west',
            width: 280,
            collapsed: true
        },
        {
            xtype: 'smsPatternGridView',
            title: 'Шаблоны сообщений',
            region: 'west',
            width: 280,
            collapsed: true
        }
    ]
});