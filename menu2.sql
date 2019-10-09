prompt Disabling triggers for MENU2...
alter table MENU2 disable all triggers;
prompt Deleting MENU2...
delete from MENU2;
commit;
prompt Loading MENU2...
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('50', '�Ŷ��¼�����', '#', 'icon-sys', '0', 1, 'D0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('100', '�嵥', 'insert', null, '50', 0, 'D0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('200', '������������', 'delay', null, '50', 0, 'D0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('300', '�豸����', 'devicefault', null, '50', 0, 'D0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('400', '����������', 'complete', null, '50', 0, 'D0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('0', '�����Ų�', '#', null, '-1', 1, 'D0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('0', '����֪ʶ', '#', 'icon-log', '-1', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('0', '����֪ʶ', '#', 'icon-log', '-1', 1, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('200', '���׼��', '#', 'icon-sys', '0', 1, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('201', '1.��ȡ�������', 'A1.1-1', 'icon-log', '200', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('202', '2.����߶Ȳ���', 'A1.1-2', 'icon-log', '200', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('203', '3.�����������', 'A1.1-3', 'icon-log', '200', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('204', '4.�����װ˿��', 'A1.1-4', null, '200', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('205', '5.���أ�ˢ�׽��������ݽ�', 'A1.1-5', null, '200', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('300', '���׼��', '#', 'icon-sys', '0', 1, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('301', '1.̼����̲㡢�̻�', 'A1.2-1', 'icon-log', '300', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('302', '2.̼������', 'A1.2-2', 'icon-log', '300', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('500', '��װ׼��', '#', 'icon-sys', '0', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('501', '1.��ȡ��װ', 'A1.4-1', 'icon-log', '500', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('502', '2.��װ���������װ', 'A1.4-2', 'icon-log', '500', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('303', '3.̼�������ĥ����ϴ', 'A1.2-3', 'icon-log', '300', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('304', '4.���ˢ�׽�', 'A1.2-4', null, '300', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('305', '5.�������Ĥ����', 'A1.2-5', null, '300', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('400', '����о׼��', '#', 'icon-sys', '0', 1, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('401', '1.���ѵ���������', 'A1.3-1', 'icon-log', '400', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('200', '���׼��', '#', 'icon-sys', '0', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('201', '1.��ȡ�������', 'A1.1-1', 'icon-log', '200', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('202', '2.����߶Ȳ���', 'A1.1-2', 'icon-log', '200', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('300', '���׼��', '#', 'icon-sys', '0', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('301', '1.��������', 'A1.2-1', 'icon-log', '300', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('400', '����о׼��', '#', 'icon-sys', '0', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('401', '1.���ѵ���������', 'A1.3-1', 'icon-log', '400', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('402', '2.����о����', 'A1.3-2', null, '400', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('600', '�ȹ�׼��', '#', 'icon-sys', '0', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('700', '��������', '#', 'icon-sys', '0', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('601', '1.��ȡ�ȹ�', 'A1.5-1', null, '600', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('203', '3.�����������', 'A1.1-3', 'icon-log', '200', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('205', '5.���أ�ˢ�׽��������ݽ�', 'A1.1-5', null, '200', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('204', '4.�����װ˿��', 'A1.1-4', null, '200', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('304', '4.���ˢ�׽�������Ĥ', 'A1.2-4', null, '300', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('303', '3.������������', 'A1.2-3', 'icon-log', '300', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('302', '2.������빤װ��װ', 'A1.2-2', 'icon-log', '300', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('305', '5.������', 'A1.2-5', null, '300', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('404', '4.����о��߶ȡ�����', 'A1.3-4', null, '400', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('403', '3.����о��ϴ', 'A1.3-3', null, '400', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('402', '2.����о����', 'A1.3-2', null, '400', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('405', '5.������/���ܷ���ƴ��', 'A1.3-5', null, '400', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('603', '3.�ȹܲ��߶ȷ��ѡ������ݽ�', 'A1.5-3', null, '600', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('602', '2.�ȹܸ߶Ȳ���������', 'A1.5-2', null, '600', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('503', '3.��װ�����ƽ��������', 'A1.4-3', null, '500', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('701', 'M1.����ǰ׼��', 'M1', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('702', 'M2.�ϸ�ǰװ��', 'M2', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('703', 'M3.�ϸ�ǰ����', 'M3', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('704', 'M4.�ϸǺ�װ��', 'M4', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('705', 'A1.��¯�Լ��Ʊ�', 'A1', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('706', 'M5.��װ', 'M5', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('707', 'M6.�̻�', 'M6', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('708', 'M7.���ͺ���', 'M7', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('709', 'Q1.���ͺ����', 'Q1', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('710', 'M8.�󽺽�', 'M8', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('711', 'Q2.���Ӻ����', 'Q2', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('712', 'Q3.��ƷԤ����', 'Q3', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('713', 'Q4.��Ʒ����', 'Q4', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('714', 'M9.��Ʒ����', 'M9', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('403', '3.����о��ϴ', 'A1.3-3', null, '400', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('404', '4.����о��߶ȡ�����', 'A1.3-4', null, '400', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('405', '5.������/���ܷ���ƴ��', 'A1.3-5', null, '400', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('500', '��װ׼��', '#', 'icon-sys', '0', 1, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('501', '1.��ȡ��װ', 'A1.4-1', 'icon-log', '500', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('502', '2.��װ�������װ', 'A1.4-2', 'icon-log', '500', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('503', '3.��װ�����ƽ��������', 'A1.4-3', null, '500', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('700', '��������', '#', 'icon-sys', '0', 1, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('701', 'M1.����ǰ׼��', 'M1', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('702', 'M2.�ϸ�ǰװ��', 'M2', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('703', 'M3.�ϸ�ǰ����', 'M3', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('704', 'M4.�ϸǺ�װ��', 'M4', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('705', 'A1.��¯�Լ��Ʊ�', 'A1', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('706', 'M5.��װ', 'M5', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('707', 'M6.�̻�', 'M6', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('708', 'M7.���ͺ���', 'M7', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('710', 'M8.�󽺽�', 'M8', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('714', 'M9.��Ʒ����', 'M9', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('709', 'Q1.���ͺ����', 'Q1', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('711', 'Q2.���Ӻ����', 'Q2', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('712', 'Q3.��ƷԤ����', 'Q3', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('713', 'Q4.��Ʒ����', 'Q4', null, '700', 0, 'C0001');
commit;
prompt 86 records loaded
prompt Enabling triggers for MENU2...
alter table MENU2 enable all triggers;
