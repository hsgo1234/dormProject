import Vue from "vue";
import upperFirst from "lodash/upperFirst";
import camelCase from "lodash/camelCase";
import store from "../store";

const requireComponent = require.context(
    // 其组件目录的相对路径
    "../",
    // 是否查询其子目录
    true,
    // 匹配基础组件文件名的正则表达式
    /[A-Z]\w+\.(vue|js)$/
);

requireComponent.keys().forEach(fileName => {
    // 获取组件配置
    const componentConfig = requireComponent(fileName);
    // 获取组件的 PascalCase 命名
    const componentName = upperFirst(
        camelCase(
            fileName = fileName.split("/")[fileName.split("/").length-1].split(".")[0]
            // 剥去文件名开头的 `./` 和结尾的扩展名
        )
    );
    // 全局注册组件
    Vue.component(
        componentName,
        // 如果这个组件选项是通过 `export default` 导出的，
        // 那么就会优先使用 `.default`，
        // 否则回退到使用模块的根。
        componentConfig.default || componentConfig
    );
});

//自动获取窗户尺寸
window.onresize = function() {
    store.commit("screenporpschange");
};