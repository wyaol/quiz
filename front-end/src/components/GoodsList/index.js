import React, {Component} from 'react';
import axios from 'axios';
import { Popover, Button, Table, Space, InputNumber } from 'antd';
import './index.css';


class GoodsList extends Component {
  state = {
    goods: [],
    goodsBuys: [{
      key: '1',
      goodsId: 1,
      goodsName: 'John Brown',
      goodsNum: 32
    }]
  };

  componentDidMount() {
    axios.get("http://localhost:8080/goods").then(res => {
      const goods = res.data;
      this.setState({
        goods
      });
    });
  }

  addOrder = () => {
    axios.post("http://localhost:8080/orders", {'order': this.state.goodsBuys}).then(res => {
      if (res.status === 201) alert('添加订单成功');
    })
  }

  addGoods = (goods) => {
    const goodsBuys = this.state.goodsBuys;
    let tag = false;
    goodsBuys.map((goodsBuy) => {
      if (goodsBuy.goodsId === goods.id) {
        goodsBuy.goodsNum +=1;
        tag = true;
      }
      return goodsBuy;
    });
    if (tag === false) goodsBuys.push({
        key: goodsBuys.length.toString(),
        goodsId: goods.id,
        goodsName: goods.name,
        goodsNum: 1,
    });
    this.setState({
      goodsBuys
    });
    console.log(this.state.goodsBuys);
  }

  render() {
    const columns = [
      {
        title: '商品',
        dataIndex: 'goodsName',
        key: 'goodsName',
        render: text => <a>{text}</a>,
      },
      {
        title: '数量',
        dataIndex: 'goodsNum',
        key: 'goodsNum',
        render: number => <InputNumber value={number} />
      },
      {
        title: 'Action',
        key: 'action',
        render: (text, record) => (
          <Space size="middle">
            <a>Delete</a>
          </Space>
        ),
      },
    ];

    const content = (
      <div>
        <Table columns={columns} dataSource={this.state.goodsBuys} />
        <button onClick={() => this.addOrder()}>立即下单</button>
        <button>清空</button>
      </div>
    );

    return (
      <div>
        {this.state.goods.map((good, index) => (
          <div className="good" key={index}>
            <img src={good.imgUrl} alt=""/>
            <span>{good.name}</span>
            <span>单价{good.price}元/{good.unit}</span>
            <button onClick={() => this.addGoods(good)}>+</button>
          </div>
        ))}

        <Popover content={content}>
          <Button type="primary">购物车</Button>
        </Popover>
      </div>
    );
  }
}

export default GoodsList;