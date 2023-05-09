package com.budwk.jedis.params;

import com.budwk.jedis.CommandArguments;
import static com.budwk.jedis.Protocol.Keyword.STORE;
import static com.budwk.jedis.Protocol.Keyword.STOREDIST;

public class GeoRadiusStoreParam implements IParams {

  private boolean store = false;
  private boolean storeDist = false;
  private String key;

  public GeoRadiusStoreParam() {
  }

  public static GeoRadiusStoreParam geoRadiusStoreParam() {
    return new GeoRadiusStoreParam();
  }

  public GeoRadiusStoreParam store(String key) {
    if (key != null) {
      this.store = true;
      this.key = key;
    }
    return this;
  }

  public GeoRadiusStoreParam storeDist(String key) {
    if (key != null) {
      this.storeDist = true;
      this.key = key;
    }
    return this;
  }

  /**
     * WARNING: In Redis, if STOREDIST exists, store will be ignored.
     * <p>
     * Refer: https://github.com/antirez/redis/blob/6.0/src/geo.c#L649
     *
   * @param args
   */
  @Override
  public void addParams(CommandArguments args) {
    if (storeDist) {
      args.add(STOREDIST).key(key);
    } else if (store) {
      args.add(STORE).key(key);
    } else {
      throw new IllegalArgumentException(this.getClass().getSimpleName()
          + " must has store or storedist option");
    }
  }
}
