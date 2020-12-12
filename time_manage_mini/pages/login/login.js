// pages/login/login.js
//获取app实例
const app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    //判断小程序的API，回调，参数，组件等是否在当前版本可用。
    canIUse: wx.canIUse("button.open-type.getUserInfo"),
  },

  bindGetUserInfo: function (e) {
    console.log("用户按了允许授权按钮", e.detail.userInfo);
    if (e.detail.userInfo) {
      //用户按了允许授权按钮
      app.doLogin(app.switchTheTab("/pages/record/record"));
    } else {
      //用户按了拒绝按钮
      console.log("用户按了拒绝按钮");
      app.showInfo("请点击允许授权，否则后续功能无法使用");
    }
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    if(wx.getStorageSync("token")){
      console.log("用户已经登陆");
      app.switchTheTab("/pages/record/record")
    }
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