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
      <table class="table table-striped">
        <thead>
          <tr>
            <th>名字</th>
            <th>单价</th>
            <th>数量</th>
            <th>单位</th>
          </tr>
        </thead>
        <tbody>
          {this.state.orders.map((order) => (
            <tr>
              <td>{order.name}</td>
              <td>{order.price}</td>
              <td>{order.num}</td>
              <td>{order.unit}</td>
            </tr>
          ))}
        </tbody>
      </table>
    )
  }
}

export default OrdersList;