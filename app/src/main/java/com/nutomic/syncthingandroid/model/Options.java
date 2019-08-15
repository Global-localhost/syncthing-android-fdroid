package com.nutomic.syncthingandroid.model;

/**
 * Sources:
 * - https://github.com/syncthing/syncthing/tree/master/lib/config
 * - https://github.com/syncthing/syncthing/blob/master/lib/config/optionsconfiguration.go
 */
public class Options {
    public String[] listenAddresses;                // default
    public String[] globalAnnounceServers;          // default
    public boolean globalAnnounceEnabled = true;
    public boolean localAnnounceEnabled = true;
    public int localAnnouncePort = 21027;
    public String localAnnounceMCAddr;              // [ff12::8384]:21027
    public int maxSendKbps = 0;
    public int maxRecvKbps = 0;
    public int reconnectionIntervalS = 60;
    public boolean relaysEnabled = true;
    public int relayReconnectIntervalM = 10;
    public boolean startBrowser = false;            // Normally "true" but makes no sense on Android.
    public boolean natEnabled = true;
    public int natLeaseMinutes = 60;
    public int natRenewalMinutes = 30;
    public int natTimeoutSeconds = 10;
    public int urAccepted = 0;                      // 0: Undecided
    public String urUniqueId;                       // Automatically generated by SyncthingNative
    public String urURL = "https://data.syncthing.net/newdata";
    public boolean urPostInsecurely = false;
    public int urInitialDelayS = 1800;
    public boolean restartOnWakeup = true;
    public int autoUpgradeIntervalH = 0;            // Normally "12" but makes no sense on Android.
    public boolean upgradeToPreReleases = false;
    public int keepTemporariesH = 24;
    public boolean cacheIgnoredFiles = false;
    public int progressUpdateIntervalS = 5;
    public boolean limitBandwidthInLan = false;
    public String releasesURL = "https://upgrades.syncthing.net/meta.json";
    public String[] alwaysLocalNets;                // Still present in SyncthingNative 1.0.1
    public boolean overwriteRemoteDeviceNamesOnConnect = false;
    public int tempIndexMinBlocks = 10;
    public String defaultFolderPath;                // Automatically generated by SyncthingNative
    public boolean setLowPriority = true;

    // Since v0.14.28, Issue #3307, PR #4087
    public MinHomeDiskFree minHomeDiskFree;

    // Since v1.0.0, see https://github.com/syncthing/syncthing/pull/4888
    public int maxConcurrentScans = 1;

    // Since v1.2.0
    public String crashReportingURL = "https://crash.syncthing.net/newcrash";
    public boolean crashReportingEnabled = true;
    public int stunKeepaliveStartS = 180;
    public int stunKeepaliveMinS = 20;
    public String stunServer = "default";

    // Items that may be temporarily missing because they are empty.
    /**
     * Possible notification IDs:
     * crAutoDisabled                  (crash reporting after upgrade to v1.2.0)
     * crAutoEnabled                   (crash reporting after upgrade to v1.2.0)
     */
    public String unackedNotificationID = "";

    public static class MinHomeDiskFree {
        public float value = 1;
        public String unit = "%";
    }

    public static final int USAGE_REPORTING_UNDECIDED = 0;
    public static final int USAGE_REPORTING_DENIED    = -1;

    public boolean isUsageReportingAccepted(int urVersionMax) {
        return urAccepted == urVersionMax;
    }

    public boolean isUsageReportingDecided(int urVersionMax) {
        return isUsageReportingAccepted(urVersionMax) || urAccepted == USAGE_REPORTING_DENIED;
    }
}
