// pages/record/record.js
//获取app实例
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    recordList: [123]
  },

  queryRecord: function () {
    let that = this;
    wx.request({
      url: "https://www.magiccjumboo.top/api/time/record",
      //url: "http://localhost:9999/api/time/record",
      method: "GET",
      header: {
        token: wx.getStorageSync("token")
      },
      success: function (res) {
        console.log("queryRecord:", res.data);
        that.setData({
          recordList: res.data.data
        });
        console.log(that.recordList);
      },
      fail: function (error) {
        // 调用服务端登录接口失败
        app.showInfo("调用接口失败");
        console.log(error);
      },
    });
  },

  addRecord: function () {
    console.log("点击+");
    app.navigateTo("/pages/record/addRecord/addRecord");
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let that = this;
    that.queryRecord();
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})