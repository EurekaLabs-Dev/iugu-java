package com.iugu.responses;

import com.iugu.enums.ItemType;
import com.iugu.model.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodResponse {

	public PaymentMethodResponse() {
	}

	private String id;

	private String description;

	private DataCard data;

	@JsonProperty("item_type")
	private ItemType itemType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public DataCard getData() {
		return data;
	}

	public void setData(DataCard data) {
		this.data = data;
	}

	private static class DataCard {
		@JsonProperty("holder_name")
		private String holderName;
		@JsonProperty("display_number")
		private String displayNumber;
		private String brand;
		private String month;
		private String year;

		public String getHolderName() {
			return holderName;
		}

		public void setHolderName(String holderName) {
			this.holderName = holderName;
		}

		public String getDisplayNumber() {
			return displayNumber;
		}

		public void setDisplayNumber(String displayNumber) {
			this.displayNumber = displayNumber;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getMonth() {
			return month;
		}

		public void setMonth(String month) {
			this.month = month;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}
	}
}
