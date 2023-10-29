package com.example;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonInitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 
/**
 * サービスを起動停止するクラス.
 *
 */
public class ServiceLauncher implements Daemon {
 
    // ランチャー
    private static ServiceLauncher launcher;
 
    // サービス
    private Service service;

    private static final Logger logger = LogManager.getLogger(ServiceLauncher.class);
 
   /** 
    * サービス実行.
    *
    */
    public void run()  {
       
        service = new Service();
        try {
            Thread t = new Thread(service );
            t.setDaemon(true);
            t.start();
            // サービスが停止するまで制御を戻したらダメ
            t.join();
        } catch (InterruptedException e) {
        }
    }
  
   /**
    * サービス停止処理
    */
    public void terminate() {
        if (service != null) {
            service .stop();
        }
    }
 
   /**
    * Windowsサービス開始時にcommons Daemonからコールされる
    *
    */
    public static void startService(String args) {
        logger.info("start startService");
        launcher = new ServiceLauncher();
        launcher.run(); // サービス停止まで制御もどってこないはず
        logger.info("end startService");
    }
 
   /**
    * Windowsサービス停止時にcommons Daemonからコールされる
    *
    * @param args
    */
    public static void stopService(String args) {
        logger.info("start stopService");
        if (launcher != null) {
            launcher.terminate();
        }
        logger.info("stop stopService");
    }
 
   /**
    * Linuxで使用した場合commons Daemonからコールされる
    * 未実装
    */
    @Override
    public void destroy() {
        // Ingore
    }
 
   /**
    * Linuxで使用した場合commons Daemonからコールされる
    * 未実装
    */
    @Override
    public void init(DaemonContext arg0) throws DaemonInitException, Exception {
        // Ingore
    }
 
   /**
    * Linuxで使用した場合commons Daemonからコールされる
    * 未実装
    */
    @Override
    public void start() throws Exception {
        // Ingore
    }
 
   /**
    * Linuxで使用した場合commons Daemonからコールされる
    * 未実装
    */
    @Override
    public void stop() throws Exception {
        // Ingore
    }
 
   /**
    * メイン関数
    * Windowsサービス時には未使用
    * @param args
    */
    public static void main(String[] args) {
        logger.info("start main");
        launcher = new ServiceLauncher();
        launcher.run();
        logger.info("end main");
        return;
    }
}
