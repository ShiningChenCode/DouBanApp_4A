package com.teamwork.doubanapp_4a.group.view.groupdata;

import java.util.List;

/**
 * Created by Administrator on 2017/4/22.
 */

public class SiftData {

	private List<MixedRecGroupsBean> mixed_rec_groups;

	public List<MixedRecGroupsBean> getMixed_rec_groups() {
		return mixed_rec_groups;
	}

	public void setMixed_rec_groups(List<MixedRecGroupsBean> mixed_rec_groups) {
		this.mixed_rec_groups = mixed_rec_groups;
	}

	public static class MixedRecGroupsBean {
		/**
		 * id : 100054
		 * image : https://img3.doubanio.com/img/files/file-1493000842.png
		 * name :
		 * uri : https://m.douban.com/page/y252dy9
		 */

		private String id;
		private String image;
		private String name;
		private String uri;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUri() {
			return uri;
		}

		public void setUri(String uri) {
			this.uri = uri;
		}
	}
}
