import Vue from "vue";
import Router from "vue-router"
import DormManage from "./components/DormManage";
import PlanTwo from "./components/subcomponents/PlanTwo";
import StuManage from "./components/StuManage";
import PlanThree from "./components/subcomponents/PlanThree";
import LoginManage from "./components/LoginManage";
import PlanFour from "./components/subcomponents/PlanFour";
import PlanFive from "./components/subcomponents/PlanFive";
import VisRecords from "./components/VisRecords";
import Overview from "./components/Overview";
import PlanOne from "./components/subcomponents/PlanOne";
import AccManage from "./components/AccManage";
import BedManage from "./components/BedManage";
import PlanSix from "./components/subcomponents/PlanSix";
Vue.use(Router);

const requireComponent = require.context(
    // 其组件目录的相对路径
    "./",
    // 是否查询其子目录
    true,
    // 匹配基础组件文件名的正则表达式
    /[A-Z]\w+\.(vue)$/
);
const routes1 = requireComponent.keys().map(fileName => {
  // 获取组件配置
  const componentConfig = requireComponent(fileName);
  const componentName = fileName.split("/")[fileName.split("/").length-1].split(".")[0];
  const component = Vue.component(
      componentName,
      // 如果这个组件选项是通过 `export default` 导出的，
      // 那么就会优先使用 `.default`，
      // 否则回退到使用模块的根。
      componentConfig.default || componentConfig
  );
  return {
    path:`/${componentName}`,
    name:componentName,
    component
  }
});

const routes2 = [{
  path:"/AccManage",
  component: AccManage
},
  {
    path:"/Overview",
    component: Overview,
    children: [
      {
        path:"PlanOne",
        component:PlanOne
      }
    ]
  },
  {
    path:"/DormManage",
    component: DormManage,
    children: [
      {
        path:"PlanTwo",
        component:PlanTwo
      }
    ]
  },
  {
    path:"/StuManage",
    component: StuManage,
    children:[
      {path:"PlanThree",
      component: PlanThree
      }
    ]
  },
  {
    path:"/LoginManage",
    component: LoginManage,
    children:[
      {path:"PlanFour",
        component: PlanFour
      }
    ]
  },
  {
    path:"/VisRecords",
    component: VisRecords,
    children:[
      {path:"PlanFive",
        component: PlanFive
      }
    ]
  },
  {
    path:"/BedManage",
    component: BedManage,
    children:[
      {path:"PlanSix",
        component: PlanSix
      }
    ]
  }
]
const routes = Object.assign(routes1,routes2);

export default new Router({
  routes
});
