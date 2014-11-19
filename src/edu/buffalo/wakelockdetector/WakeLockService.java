//
//
//package edu.buffalo.wakelockdetector;
//
//import android.app.ActivityManager;
//import android.app.Notification;
//import android.app.PendingIntent;
//import android.app.Service;
//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.IBinder;
//import android.preference.PreferenceManager;
//import android.util.Log;
//import eu.thedarken.wl.b.a;
//import eu.thedarken.wl.b.b;
//import eu.thedarken.wl.b.c;
//import eu.thedarken.wl.b.d;
//import eu.thedarken.wl.b.e;
//import eu.thedarken.wl.b.f;
//import eu.thedarken.wl.b.g;
//import eu.thedarken.wl.b.h;
//import eu.thedarken.wl.b.i;
//import eu.thedarken.wl.b.j;
//import java.util.Iterator;
//import java.util.List;
//
//// Referenced classes of package eu.thedarken.wl:
////            MainActivity
//
//public class WakeLockService extends Service
//{
//
//    private final String a = this.getPackageName();
//    private a b;
//    private SharedPreferences c;
//    private boolean d;
//    private String e;
//
//    public WakeLockService()
//    {
//        b = new f();
//        d = true;
//    }
//
//    private void a(b b1)
//    {
//        if (b1 != b.a) goto _L2; else goto _L1
//_L1:
//        b = new f();
//_L4:
//        Log.i(a, (new StringBuilder("Aquiring ")).append(b.c()).toString());
//        a(false);
//        return;
//_L2:
//        if (b1 == b.b)
//        {
//            b = new j(this);
//        } else
//        if (b1 == b.c)
//        {
//            b = new h(this);
//        } else
//        if (b1 == b.d)
//        {
//            b = new i(this);
//        } else
//        if (b1 == b.e)
//        {
//            b = new g(this);
//        } else
//        if (b1 == b.f)
//        {
//            b = new d(this);
//        } else
//        if (b1 == b.g)
//        {
//            b = new c(this);
//        } else
//        if (b1 == b.h)
//        {
//            b = new e(this);
//        }
//        if (true) goto _L4; else goto _L3
//_L3:
//    }
//
//    private void a(boolean flag)
//    {
//        Intent intent = new Intent();
//        intent.setAction("eu.thedarken.wl.widget.ACTION_UPDATE_WIDGET_FROM_SERVICE");
//        intent.putExtra("destroying", flag);
//        intent.putExtra("locktype", b.d());
//        sendBroadcast(intent);
//    }
//
//    public static boolean a(Context context)
//    {
//        Iterator iterator = ((ActivityManager)context.getSystemService("activity")).getRunningServices(0x7fffffff).iterator();
//        android.app.ActivityManager.RunningServiceInfo runningserviceinfo;
//        do
//        {
//            if (!iterator.hasNext())
//            {
//                return false;
//            }
//            runningserviceinfo = (android.app.ActivityManager.RunningServiceInfo)iterator.next();
//        } while (!eu/thedarken/wl/WakeLockService.getName().equals(runningserviceinfo.service.getClassName()));
//        Log.d(context.getClass().getCanonicalName(), "WakeLock service active");
//        return true;
//    }
//
//    public IBinder onBind(Intent intent)
//    {
//        return null;
//    }
//
//    public void onCreate()
//    {
//        super.onCreate();
//        Log.d(a, "creating");
//        c = PreferenceManager.getDefaultSharedPreferences(this);
//        e = c.getString("current_lock", b.a.name());
//        a(eu.thedarken.wl.b.b.valueOf(e));
//        b.a();
//        d = c.getBoolean("notifaction.enabled", true);
//        if (d)
//        {
//            Notification notification = new Notification(0x7f020001, "WakeLock active!", System.currentTimeMillis());
//            Intent intent = new Intent(this, eu/thedarken/wl/MainActivity);
//            intent.setFlags(0x24000000);
//            PendingIntent pendingintent = PendingIntent.getActivity(this, 0, intent, 0);
//            notification.setLatestEventInfo(this, "WakeLock", (new StringBuilder("Holding: ")).append(b.c()).toString(), pendingintent);
//            notification.flags = 0x20 | notification.flags;
//            notification.flags = 0x40 | notification.flags;
//            notification.flags = 2 | notification.flags;
//            startForeground(88, notification);
//        }
//    }
//
//    public void onDestroy()
//    {
//        super.onDestroy();
//        Log.d(a, "destroying");
//        Log.i(a, (new StringBuilder("Releasing ")).append(b.c()).toString());
//        b.b();
//        e = c.getString("current_lock", b.a.name());
//        a(eu.thedarken.wl.b.b.valueOf(e));
//        stopForeground(true);
//        Log.d(a, "bye...");
//        a(true);
//    }
//}
