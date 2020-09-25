import React, {Component} from 'react';
import axios from 'axios';
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

  render() {
    return (
      <div>
        {this.state.goods.map((good, index) => (
          <div className="good">
            <img src={good.imgUrl} alt=""/>
            <span>{good.name}</span>
            <span>单价{good.price}元/{good.unit}</span>
            <div>+</div>
          </div>
        ))}
      </div>
    );
  }
}

export default GoodsList;