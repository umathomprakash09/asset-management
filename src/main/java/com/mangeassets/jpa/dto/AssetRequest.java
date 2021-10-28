package com.mangeassets.jpa.dto;

import com.mangeassets.jpa.model.Asset;

public class AssetRequest {
	private Asset asset;
	int catId;
	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	@Override
	public String toString() {
		return "AssetRequest [asset=" + asset + "]";
	}
	
	

}
