import React, {Component} from 'react';
import axios from 'axios';
import './index.css';
import Header from '../Herder';


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
    return (
      <div>
        {this.state.goods.map((good, index) => (
          <div className="good">
            <img src={good.imgUrl} alt=""/>
            <span>{good.name}</span>
            <span>单价{good.price}元/{good.unit}</span>
            <button onClick={() => this.addOrder(good.id)}>+</button>
          </div>
        ))}
      </div>
    );
  }
}

export default GoodsList;