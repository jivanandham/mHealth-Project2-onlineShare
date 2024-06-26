package edu.pitt.lersais.mhealth.handlers;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * The CryptoMessageHandler that is used to process the decrypted record.
 */
public class CryptoMessageHandler extends Handler {

    private Callback callback;

    public CryptoMessageHandler(Looper looper) {
        super(looper);
    }

    @Override
    public void handleMessage(Message msg) {
        if (callback != null) {
            callback.processCryptoRecord(msg.obj);
        }
    }

    public interface Callback {
        void processCryptoRecord(Object record);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }
}