import React, {Component} from 'react';
import axios from 'axios';
import './index.css';


class OrdersList extends Component {
  state = {
    orders: [],
  };

  componentDidMount() {
    axios.get("http://localhost:8080/orders").then(res => {
      const orders = res.data;
      this.setState({
        orders
      });
    });
  }

  render() {
    return (
      this.state.orders.map((order) => (
        <table class="table table-striped">
          <caption>订单号： {order.orderId}</caption>
          <thead>
            <tr>
              <th>#</th>
              <th>名字</th>
              <th>数量</th>
              <th>单价</th>
              <th>单位</th>
            </tr>
          </thead>
          <tbody>
            {order.goodsList.map((goods, index) => (
              <tr>
                <td>{index+1}</td>
                <td>{goods.name}</td>
                <td>{goods.num}</td>
                <td>{goods.price}</td>
                <td>{goods.unit}</td>
              </tr>
            ))}
            <tr>
              <td colSpan={2}>总价</td>
              <td colSpan={2}>{order.goodsList.reduce((sum, goods) => {return sum + goods.price}, 0)}</td>
            </tr>
          </tbody>
        </table>
      ))
    )
  }
}

export default OrdersList;