package com.sas.webapp.config;

/**
 * Application constants.
 */
public final class Constants {

    private Constants() {
    }

    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    public static final String SPRING_PROFILE_FAST = "fast";
    public static final String SPRING_PROFILE_CLOUD = "cloud";
    public static final String SYSTEM_ACCOUNT = "system";

    
    public static final String[] LESSON_COLORS = new String[]{
    	"#61ECF4",
    	"#60BAF3",
    	"#8068FF",
    	"#0FB9C1",
    	"#0C71B2",
    	"#4935B6",
    	"#096F74",
    	"#083977",
    	"#271C61",
    	"#0EDBE2",
    	"#0F90E2",
    	"#6045EE",
    	"#0D9EA5",
    	"#065687",
    	"#362786"
    };
    
    public static final String[] MONTHS = new String[]{
    	"Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran", "Temmuz", "Ağustos", "Eylül", "Ekim", "Kasım", "Aralık"
    };
}
