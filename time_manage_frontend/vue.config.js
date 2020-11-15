module.exports = {
  publicPath:"./",
  devServer: {
    proxy: {
      '/ci/api': {
        target: "http://localhost:7000",
        changeOrigin: true,
        headers: {
          host: "http://localhost:7000",
          origin: "http://localhost:7000"
        }
      },

    }
  }
}