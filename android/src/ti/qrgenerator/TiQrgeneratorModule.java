/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Titanium SDK
 * Copyright TiDev, Inc. 04/07/2022-Present
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */
package ti.qrgenerator;

import android.graphics.Bitmap;
import android.graphics.Color;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiBlob;
import org.appcelerator.titanium.util.TiConvert;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;


@Kroll.module(name = "TiQrgenerator", id = "ti.qrgenerator")
public class TiQrgeneratorModule extends KrollModule {

    // Standard Debugging variables
    private static final String LCAT = "TiQrgeneratorModule";
    private static final boolean DBG = TiConfig.LOGD;

    // You can define constants with @Kroll.constant, for example:
    // @Kroll.constant public static final String EXTERNAL_NAME = value;

    public TiQrgeneratorModule() {
        super();
    }

    @Kroll.onAppCreate
    public static void onAppCreate(TiApplication app) {
    }

    // Methods
    @Kroll.method
    public TiBlob generate(KrollDict options) {
        String text = options.getString("text");
        int dimension = TiConvert.toInt(options.get("dimension"), 100);
        int margin = TiConvert.toInt(options.get("margin"), 2);
        QRGEncoder qrgEncoder = new QRGEncoder(text, null, QRGContents.Type.TEXT, dimension);

        if (options.containsKeyAndNotNull("backgroundColor")) {
            int colorBlack = TiConvert.toColor(options.getString("backgroundColor"), TiApplication.getAppCurrentActivity());
            qrgEncoder.setColorBlack(colorBlack);
        } else {
//            qrgEncoder.setColorBlack(Color.BLACK);
        }
        if (options.containsKeyAndNotNull("color")) {
            int colorWhite = TiConvert.toColor(options.getString("color"), TiApplication.getAppCurrentActivity());
            qrgEncoder.setColorWhite(colorWhite);
        } else {
//            qrgEncoder.setColorWhite(Color.WHITE);
        }

        try {
            // Getting QR-Code as Bitmap
            Bitmap bitmap = qrgEncoder.getBitmap(margin);
            // Setting Bitmap to ImageView
            return TiBlob.blobFromImage(bitmap);
        } catch (Exception e) {
            Log.e(LCAT, "Error generating QR code");
        }
        return null;
    }

}
