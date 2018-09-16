package interfaces;

public interface IConfiguration {

    void loadConfiguration();
    String getConfigurationSection();
    void selectConfigurationSection();
    String getItem(String key);
    void setItem(String key);


}
