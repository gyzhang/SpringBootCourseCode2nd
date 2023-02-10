const routes = [
    {
        name: 'foo',
        path: '/foo',
        component: () => import('@/views/Foo.vue')
    },
    {
        name: 'bar',
        path: '/bar',
        component: () => import('@/views/Bar.vue')
    },
    
];

export default routes