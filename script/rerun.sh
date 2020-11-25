#终止原服务
pid = `ps aux | grep level6shift.jar | grep -v grep | awk '{print $2}'`;
if [[ ${pid} ]]; then
	echo '(～￣▽￣)～ 程序正在运行，终止程序'
	kill -9 ${pid}
else
	echo '(～￣▽￣)～ 程序已经终止'
fi
#启动新服务
nohup java -Xmx1024M -jar /root/temp/level6shift/level6shift.jar >> /root/temp/level6shift/info.log &
#查看日志
tail -f /root/temp/level6shift/info.log