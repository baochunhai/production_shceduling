prompt Disabling triggers for MENU2...
alter table MENU2 disable all triggers;
prompt Deleting MENU2...
delete from MENU2;
commit;
prompt Loading MENU2...
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('50', '扰动事件驱动', '#', 'icon-sys', '0', 1, 'D0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('100', '插单', 'insert', null, '50', 0, 'D0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('200', '生产进度延期', 'delay', null, '50', 0, 'D0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('300', '设备故障', 'devicefault', null, '50', 0, 'D0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('400', '齐套性问题', 'complete', null, '50', 0, 'D0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('0', '工序排产', '#', null, '-1', 1, 'D0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('0', '工艺知识', '#', 'icon-log', '-1', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('0', '工艺知识', '#', 'icon-log', '-1', 1, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('200', '埋件准备', '#', 'icon-sys', '0', 1, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('201', '1.领取金属埋件', 'A1.1-1', 'icon-log', '200', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('202', '2.埋件高度测量', 'A1.1-2', 'icon-log', '200', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('203', '3.埋件表面磷酸', 'A1.1-3', 'icon-log', '200', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('204', '4.埋件安装丝套', 'A1.1-4', null, '200', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('205', '5.称重，刷底胶，包发泡胶', 'A1.1-5', null, '200', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('300', '面板准备', '#', 'icon-sys', '0', 1, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('301', '1.碳面板铺层、固化', 'A1.2-1', 'icon-log', '300', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('302', '2.碳面板机加', 'A1.2-2', 'icon-log', '300', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('500', '工装准备', '#', 'icon-sys', '0', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('501', '1.领取工装', 'A1.4-1', 'icon-log', '500', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('502', '2.工装与铝面板试装', 'A1.4-2', 'icon-log', '500', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('303', '3.碳面板表面打磨、清洗', 'A1.2-3', 'icon-log', '300', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('304', '4.面板刷底胶', 'A1.2-4', null, '300', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('305', '5.面板贴胶膜称重', 'A1.2-5', null, '300', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('400', '蜂窝芯准备', '#', 'icon-sys', '0', 1, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('401', '1.蜂窝叠层条机加', 'A1.3-1', 'icon-log', '400', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('200', '埋件准备', '#', 'icon-sys', '0', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('201', '1.领取金属埋件', 'A1.1-1', 'icon-log', '200', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('202', '2.埋件高度测量', 'A1.1-2', 'icon-log', '200', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('300', '面板准备', '#', 'icon-sys', '0', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('301', '1.铝面板机加', 'A1.2-1', 'icon-log', '300', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('400', '蜂窝芯准备', '#', 'icon-sys', '0', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('401', '1.蜂窝叠层条机加', 'A1.3-1', 'icon-log', '400', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('402', '2.蜂窝芯拉伸', 'A1.3-2', null, '400', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('600', '热管准备', '#', 'icon-sys', '0', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('700', '其他工序', '#', 'icon-sys', '0', 1, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('601', '1.领取热管', 'A1.5-1', null, '600', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('203', '3.埋件表面磷酸', 'A1.1-3', 'icon-log', '200', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('205', '5.称重，刷底胶，包发泡胶', 'A1.1-5', null, '200', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('204', '4.埋件安装丝套', 'A1.1-4', null, '200', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('304', '4.面板刷底胶、贴胶膜', 'A1.2-4', null, '300', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('303', '3.铝面板表面磷酸', 'A1.2-3', 'icon-log', '300', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('302', '2.铝面板与工装试装', 'A1.2-2', 'icon-log', '300', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('305', '5.面板称重', 'A1.2-5', null, '300', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('404', '4.蜂窝芯测高度、称重', 'A1.3-4', null, '400', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('403', '3.蜂窝芯清洗', 'A1.3-3', null, '400', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('402', '2.蜂窝芯拉伸', 'A1.3-2', null, '400', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('405', '5.主蜂窝/加密蜂窝拼接', 'A1.3-5', null, '400', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('603', '3.热管补高度蜂窝、包发泡胶', 'A1.5-3', null, '600', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('602', '2.热管高度测量、称重', 'A1.5-2', null, '600', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('503', '3.工装表面刮平、贴氟布', 'A1.4-3', null, '500', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('701', 'M1.复合前准备', 'M1', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('702', 'M2.合盖前装配', 'M2', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('703', 'M3.合盖前检验', 'M3', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('704', 'M4.合盖后装配', 'M4', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('705', 'A1.随炉试件制备', 'A1', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('706', 'M5.封装', 'M5', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('707', 'M6.固化', 'M6', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('708', 'M7.成型后处理', 'M7', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('709', 'Q1.成型后检验', 'Q1', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('710', 'M8.后胶接', 'M8', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('711', 'Q2.胶接后检验', 'Q2', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('712', 'Q3.产品预验收', 'Q3', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('713', 'Q4.产品验收', 'Q4', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('714', 'M9.产品交付', 'M9', null, '700', 0, 'A0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('403', '3.蜂窝芯清洗', 'A1.3-3', null, '400', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('404', '4.蜂窝芯测高度、称重', 'A1.3-4', null, '400', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('405', '5.主蜂窝/加密蜂窝拼接', 'A1.3-5', null, '400', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('500', '工装准备', '#', 'icon-sys', '0', 1, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('501', '1.领取工装', 'A1.4-1', 'icon-log', '500', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('502', '2.工装与面板试装', 'A1.4-2', 'icon-log', '500', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('503', '3.工装表面刮平、贴氟布', 'A1.4-3', null, '500', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('700', '其他工序', '#', 'icon-sys', '0', 1, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('701', 'M1.复合前准备', 'M1', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('702', 'M2.合盖前装配', 'M2', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('703', 'M3.合盖前检验', 'M3', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('704', 'M4.合盖后装配', 'M4', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('705', 'A1.随炉试件制备', 'A1', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('706', 'M5.封装', 'M5', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('707', 'M6.固化', 'M6', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('708', 'M7.成型后处理', 'M7', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('710', 'M8.后胶接', 'M8', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('714', 'M9.产品交付', 'M9', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('709', 'Q1.成型后检验', 'Q1', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('711', 'Q2.胶接后检验', 'Q2', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('712', 'Q3.产品预验收', 'Q3', null, '700', 0, 'C0001');
insert into MENU2 (menuid, menuname, url, icon, pid, is_parent, type)
values ('713', 'Q4.产品验收', 'Q4', null, '700', 0, 'C0001');
commit;
prompt 86 records loaded
prompt Enabling triggers for MENU2...
alter table MENU2 enable all triggers;
