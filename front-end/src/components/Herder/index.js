import React, {Component} from 'react';
import { Menu } from 'antd';
import { MailOutlined } from '@ant-design/icons';
import {Link} from 'react-router-dom';


class Header extends Component {
  state = {
    current: 'store',
  };

  handleClick = e => {
    this.setState({ current: e.key });
  };

  render() {
    const { current } = this.state;
    return (
      <Menu onClick={this.handleClick} selectedKeys={[current]} mode="horizontal">
        <Menu.Item key="store" icon={<MailOutlined />}>
          <Link to="/goods">商城</Link>
        </Menu.Item>
        <Menu.Item key="order" icon={<MailOutlined />}>
        <Link to="/orders">订单</Link>
        </Menu.Item>
        <Menu.Item key="goodsAdd" icon={<MailOutlined />}>
          <Link to="/goods/add">添加商品</Link>
        </Menu.Item>
      </Menu>
    );
  }
}

export default Header;