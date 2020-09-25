import { Form, Input, Button } from 'antd';
import axios from 'axios';
import React from 'react';
const layout = {
  labelCol: {
    span: 8,
  },
  wrapperCol: {
    span: 16,
  },
};
const tailLayout = {
  wrapperCol: {
    offset: 8,
    span: 16,
  },
};

const GoodsAdd = () => {

  const onFinish = (values) => {
    console.log('Success:', values);
    axios.post('http://localhost:8080/goods', values).then(res => {
      if (res.status === 201) alert('添加商品成功');
    })
  };

  const onFinishFailed = (errorInfo) => {
    console.log('Failed:', errorInfo);
  };

  return (
    <Form
      {...layout}
      name="basic"
      initialValues={{
        remember: true,
      }}
      onFinish={onFinish}
      onFinishFailed={onFinishFailed}
    >
      <Form.Item
        label="名称"
        name="name"
        rules={[
          {
            required: true,
            message: 'Please input name',
          },
        ]}
      >
        <Input />
      </Form.Item>

      <Form.Item
        label="价格"
        name="price"
        rules={[
          {
            required: true,
            message: 'Please input price',
          },
        ]}
      >
        <Input />
      </Form.Item>

      <Form.Item
        label="单位"
        name="unit"
        rules={[
          {
            required: true,
            message: 'Please input unit',
          },
        ]}
      >
        <Input />
      </Form.Item>

      <Form.Item
        label="图片"
        name="imgUrl"
        rules={[
          {
            required: true,
            message: 'Please input imgUrl',
          },
        ]}
      >
        <Input />
      </Form.Item>

      <Form.Item {...tailLayout}>
        <Button type="primary" htmlType="submit">
          提交
        </Button>
      </Form.Item>
    </Form>
  );
};

export default GoodsAdd;