import React, {Component} from 'react';
import axios from 'axios';
import { Popover, Button, Table, Space, InputNumber } from 'antd';
import './index.css';


class GoodsList extends Component {
  state = {
    goods: [],
  };

  componentDidMount() {
    axios.get("http://localhost:8080/goods").then(res => {
      const goods = res.data;
      this.setState({
        goods
      });
    });
  }

  addOrder = (id) => {
    const formData = new FormData();
    formData.append('goodId', id);
    axios.post("http://localhost:8080/orders", formData).then(res => {
      if (res.status === 201) alert('添加订单成功');
    })
  }

  render() {
    const columns = [
      {
        title: '商品',
        dataIndex: 'goods',
        key: 'goods',
        render: text => <a>{text}</a>,
      },
      {
        title: '数量',
        dataIndex: 'number',
        key: 'number',
        render: number => <InputNumber min={1} max={10} defaultValue={1} />
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
    
    const data = [
      {
        key: '1',
        goods: 'John Brown',
        number: 32,
      }
    ];

    const content = (
      <div>
        <Table columns={columns} dataSource={data} />
        <button>立即下单</button>
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
            <button onClick={() => this.addOrder(good.id)}>+</button>
          </div>
        ))}

        <Popover content={content} title="Title">
          <Button type="primary">Hover me</Button>
        </Popover>
      </div>
    );
  }
}

export default GoodsList;