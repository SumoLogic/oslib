package nu.redpois0n.oslib.windows;

import nu.redpois0n.oslib.VersionCompare;

public enum WindowsVersion implements VersionCompare {

    WIN2000("Windows 2000"),
    WINXP("Windows XP"),
    WINSERVER2003("Windows 2003"), // Note that Windows Server 2003 identifies itself only as Windows 2003
    WINVISTA("Windows Vista"),
    WINSERVER2008("Windows Server 2008"),
    WINSERVER2008R2("Windows Server 2008 R2"),
    WIN7("Windows 7"),
    WIN81("Windows 8.1"),
    WIN8("Windows 8"),
    WINSERVER2012("Windows Server 2012"),
    WINSERVER2012R2("Windows Server 2012 R2"),
    WIN10("Windows 10"),
    WINSERVER2016("Windows Server 2016"),
    WINSERVER2019("Windows Server 2019"),
    UNKNOWN(System.getProperty("os.name"));   // if we are here, we can confidently use this

    private final String search;
    private final String version;

    WindowsVersion(String search) {
        this.search = search;
        this.version = System.getProperty("os.version");
    }

    public String getSearch() {
        return search;
    }

    public String getVersion() {
        return version;
    }

    /**
     * Returns WindowsVersion for current machine
     */
    public static WindowsVersion getFromString() {
        return getFromString(System.getProperty("os.name"));
    }

    /**
     * @param search Can only be strings like "windows 8", not version number
     *
     * @return WindowsVersion from string
     */
    public static WindowsVersion getFromString(String search) {
        for (WindowsVersion v : WindowsVersion.values()) {
            if (v != UNKNOWN && v.getSearch().equalsIgnoreCase(search)) {
                return v;
            }
        }

        return UNKNOWN;
    }

    @Override
    public boolean isNewer(Enum<?> e) {
        return this.ordinal() > e.ordinal();
    }

    @Override
    public boolean isOlder(Enum<?> e) {
        return this.ordinal() < e.ordinal();
    }

}
