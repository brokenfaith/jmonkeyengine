package com.g3d.asset;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.WeakHashMap;

/**
 * An <code>AssetCache</code> allows storage of loaded resources in order
 * to improve their access time if they are requested again in a short period
 * of time. The AssetCache stores weak references to the resources, allowing
 * Java's garbage collector to request deletion of rarely used resources
 * when heap memory is low.
 */
public class AssetCache {

    private final WeakHashMap<AssetKey, Asset> smartCache = new WeakHashMap<AssetKey, Asset>();
    private final HashMap<AssetKey, Object> regularCache = new HashMap<AssetKey, Object>();


    /**
     * Adds a resource to the cache.
     * <br/><br/>
     * <font color="red">Thread-safe.</font>
     * @see #getFromCache(java.lang.String)
     */
    public void addToCache(AssetKey key, Object obj){
        synchronized (regularCache){
            if (obj instanceof Asset && key.useSmartCache()){
                // put in smart cache
                Asset asset = (Asset) obj;
                asset.setKey(null); // no circular references
                smartCache.put(key, asset);
            }else{
                // put in regular cache
                regularCache.put(key, obj);
            }
        }
    }

    /**
     * Gets an object from the cache given an asset key.
     * <br/><br/>
     * <font color="red">Thread-safe.</font>
     * @param key
     * @return
     */
    public Object getFromCache(AssetKey key){
        synchronized (regularCache){
            return regularCache.get(key);
        }
    }

    /**
     * Deletes all the assets in the regular cache.
     */
    public void deleteAllAssets(){
        synchronized (regularCache){
            regularCache.clear();
        }
    }
}