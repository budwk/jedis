package com.budwk.jedis.commands;

import java.util.List;
import java.util.Map;

import com.budwk.jedis.GeoCoordinate;
import com.budwk.jedis.Response;
import com.budwk.jedis.args.GeoUnit;
import com.budwk.jedis.params.GeoAddParams;
import com.budwk.jedis.params.GeoRadiusParam;
import com.budwk.jedis.params.GeoRadiusStoreParam;
import com.budwk.jedis.params.GeoSearchParam;
import com.budwk.jedis.resps.GeoRadiusResponse;

public interface GeoPipelineCommands {

  Response<Long> geoadd(String key, double longitude, double latitude, String member);

  Response<Long> geoadd(String key, Map<String, GeoCoordinate> memberCoordinateMap);

  Response<Long> geoadd(String key, GeoAddParams params, Map<String, GeoCoordinate> memberCoordinateMap);

  Response<Double> geodist(String key, String member1, String member2);

  Response<Double> geodist(String key, String member1, String member2, GeoUnit unit);

  Response<List<String>> geohash(String key, String... members);

  Response<List<GeoCoordinate>> geopos(String key, String... members);

  Response<List<GeoRadiusResponse>> georadius(String key, double longitude, double latitude, double radius,
      GeoUnit unit);

  Response<List<GeoRadiusResponse>> georadiusReadonly(String key, double longitude, double latitude,
      double radius, GeoUnit unit);

  Response<List<GeoRadiusResponse>> georadius(String key, double longitude, double latitude, double radius,
      GeoUnit unit, GeoRadiusParam param);

  Response<List<GeoRadiusResponse>> georadiusReadonly(String key, double longitude, double latitude,
      double radius, GeoUnit unit, GeoRadiusParam param);

  Response<List<GeoRadiusResponse>> georadiusByMember(String key, String member, double radius, GeoUnit unit);

  Response<List<GeoRadiusResponse>> georadiusByMemberReadonly(String key, String member, double radius, GeoUnit unit);

  Response<List<GeoRadiusResponse>> georadiusByMember(String key, String member, double radius, GeoUnit unit,
      GeoRadiusParam param);

  Response<List<GeoRadiusResponse>> georadiusByMemberReadonly(String key, String member, double radius,
      GeoUnit unit, GeoRadiusParam param);

  Response<Long> georadiusStore(String key, double longitude, double latitude, double radius, GeoUnit unit,
      GeoRadiusParam param, GeoRadiusStoreParam storeParam);

  Response<Long> georadiusByMemberStore(String key, String member, double radius, GeoUnit unit,
      GeoRadiusParam param, GeoRadiusStoreParam storeParam);

  Response<List<GeoRadiusResponse>> geosearch(String key, String member, double radius, GeoUnit unit);

  Response<List<GeoRadiusResponse>> geosearch(String key, GeoCoordinate coord, double radius, GeoUnit unit);

  Response<List<GeoRadiusResponse>> geosearch(String key, String member, double width, double height, GeoUnit unit);

  Response<List<GeoRadiusResponse>> geosearch(String key, GeoCoordinate coord, double width, double height, GeoUnit unit);

  Response<List<GeoRadiusResponse>> geosearch(String key, GeoSearchParam params);

  Response<Long> geosearchStore(String dest, String src, String member, double radius, GeoUnit unit);

  Response<Long> geosearchStore(String dest, String src, GeoCoordinate coord, double radius, GeoUnit unit);

  Response<Long> geosearchStore(String dest, String src, String member, double width, double height, GeoUnit unit);

  Response<Long> geosearchStore(String dest, String src, GeoCoordinate coord, double width, double height, GeoUnit unit);

  Response<Long> geosearchStore(String dest, String src, GeoSearchParam params);

  Response<Long> geosearchStoreStoreDist(String dest, String src, GeoSearchParam params);
}
