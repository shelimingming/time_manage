// pages/login/login.js
//获取app实例
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    token: wx.getStorageSync("loginFlag"),
    userInfo: {},
    //判断小程序的API，回调，参数，组件等是否在当前版本可用。
    canIUse: wx.canIUse("button.open-type.getUserInfo"),
    // 是否登录，根据后台返回的token判断
    hasLogin: wx.getStorageSync("loginFlag") ? true : false,
  },

  bindGetUserInfo: function (e) {
    console.log("用户按了允许授权按钮", e.detail.userInfo);
    if (e.detail.userInfo) {
      //用户按了允许授权按钮
      app.doLogin(app.switchTheTab);
    } else {
      //用户按了拒绝按钮
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("token:" + this.token);
    console.log("canIUse:" + this.canIUse);
    console.log("hasLogin:" + this.hasLogin);
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