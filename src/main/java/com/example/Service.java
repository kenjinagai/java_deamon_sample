package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * サービスクラス.
 *
 */
public class Service implements Runnable {
    // 実行中フラグ
    private boolean isRunning = false;
     private static final Logger logger = LogManager.getLogger(ServiceLauncher.class);

   /**
    * コンストラクタ.
    */
    public Service () {
    }
  
   /**
    * サービスを停止する。
    *
    */
    public void stop() {
        isRunning = false;
    }
 
   /**
    * スケジューラを開始する。
    *
    */
    @Override
    public void run() {
        isRunning = true;
        logger.info("start run");
 
        while (isRunning) {
            logger.info("isRunning");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        logger.info("end run");
    }
}
